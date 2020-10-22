import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PecScrappar {   
    public static HashSet<String> link = new HashSet<>();
    public static HashSet<String> faculty = new HashSet<>();

//set which contains final tag values after scrapping
    public static Set<Object[]> tags = new HashSet<>();
//set which contains final faculty scrapped data
    public static Set<Object[]> fac = new HashSet<>();

// Scrapper to scape links
    public static void scrapper(String url) throws IOException {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements link = doc.select("*");
            for (Element links : link) {
                if (links.text().equals("") || links.tagName().equals(""))
                    continue;
                tags.add(new Object[]{
                        links.tagName(), links.text()});
            }
        } catch (HttpStatusException e) {
            System.out.println("Connection timed-out");
        } catch(Exception e){
            System.out.println("Invalid Url");
        }
    }

//full scrapping function for pec site 
    public static void ScrapparFunction(String PecSiteUrl) throws IOException {
        Queue<String > pending = new LinkedList<>();
        String[] keywords = {"png", "PNG", "pdf", "PDF", "jpg","JPG", "jpeg", "JPEG" ,"doc", "DOC", "xlsx", "ppt", "events", "#", "donations", "tnp",  "jobs", "tenders"};
        String[] keys = {"faculty/civil", "faculty/cse", "faculty/aero", "faculty/applied-sciences", "faculty/ee", "faculty/ece", "faculty/me", "faculty/metta", "faculty/pie"};

        pending.add(PecSiteUrl);
        link.add(PecSiteUrl);
        int depthOfScrapping = 0;
        while(depthOfScrapping < 5 && !pending.isEmpty()){
            depthOfScrapping++;
            int size=pending.size();

            while(size!=0){
                size--;
                String url = pending.poll();
                assert url != null;
                boolean flag1 = Arrays.stream(keys).anyMatch(url::contains);
                scrapper(url);
                try{
                    Document document = Jsoup.connect(url).get();
                    Elements linksOnPage = document.select("a[href]");
                    for(Element pages: linksOnPage){
                        String crawled=pages.attr("abs:href");
                        boolean flag= Arrays.stream(keywords).anyMatch(crawled::contains);
                        if(flag1 && !link.contains(crawled) && !flag && crawled.startsWith(PecSiteUrl)){
                            faculty.add(crawled);
                        }
                        if(!link.contains(crawled) && !flag && crawled.startsWith(PecSiteUrl)){
                            System.out.println(">> DepthOfScrapping: " + depthOfScrapping + " [" + crawled + "]");
                            link.add(crawled);
                            pending.add(crawled);
                        }

                    }
                } catch (HttpStatusException e){
                    System.out.println("System Error Code 404");
                } catch (MalformedURLException e){
                    System.out.println("Url is not of Standard Type");
                } catch(IOException e){
                    System.out.println("Invalid Url");
                } catch (Exception e){
                    System.out.println("Invalid Url");
                }

            }
        }
    }

//adding the above scrapped data to a excel file
    public static void addTagInfo(){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet(" Tag_Info ");
            Row r = spreadsheet.createRow(spreadsheet.getLastRowNum()+1);
            int c = 0;
            String[] headings = {"Tags", "Text"};
            for(String headers: headings){
                Cell cel =r.createCell(c++);
                cel.setCellValue(headers);
            }
            r = spreadsheet.createRow(spreadsheet.getLastRowNum()+1);
            c = 0;
            for(String ignored : headings){
                Cell cel =r.createCell(c++);
                cel.setCellValue("");
            }
            for(Object[] objArr: tags){
                Row row = spreadsheet.createRow(spreadsheet.getLastRowNum()+1);
                int cellid = 0;
                for (Object obj : objArr){
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((String)obj);
                }
            }
            try{
                FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Aayush Garg\\Desktop\\data.xlsx"));
                workbook.write(out);
                out.close();
            } catch (IOException e){
                System.out.println("Can't access file....");
            } catch (Exception e){
                System.out.println("Invalid access...!!");
            }
    }

// adding scrapped faculty data to excel file
    public static void addFacultyData() throws IOException {
        XSSFWorkbook workbook1 = new XSSFWorkbook();
        XSSFSheet spreadsheet1 = workbook1.createSheet(" Faculty_Info ");
        Row r = spreadsheet1.createRow(spreadsheet1.getLastRowNum()+1);
        int c = 0;
        String[] headings = {"Name", "Department", "Designation", "Qualification", "Research Interests", "Address", "Email", "Phone Number"};
        for(String head: headings){
            Cell cel =r.createCell(c++);
            cel.setCellValue(head);
        }
        r = spreadsheet1.createRow(spreadsheet1.getLastRowNum()+1);
        c = 0;
        for(String ignored : headings){
            Cell cel =r.createCell(c++);
            cel.setCellValue("");
        }
        for(Object[] objArr: fac){
            Row row = spreadsheet1.createRow(spreadsheet1.getLastRowNum()+1);
            int cellid = 0;
            for (Object obj : objArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        try{
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Aayush Garg\\Desktop\\faculty.xlsx"));
            workbook1.write(out);
            out.close();
        } catch (IOException e){
            System.out.println("Can't access file....");
        } catch (Exception e){
            System.out.println("Invalid access...!!");
        }
    }

    public static void main(String[] args) throws IOException{
        ScrapparFunction("https://pec.ac.in");
        //adding scrapped data into excel file
        addTagInfo();

        //adding values to faculty info scrapped file
        for(String url: faculty){
            Document doc = Jsoup.connect(url).get();
            Element heading = doc.select("div.panel-heading").first();
            Element table = doc.selectFirst("tbody");
            if(table != null){
                Elements rows = table.select("tr");
                Object[] objArr = new Object[rows.size()+1];
                objArr[0] = heading.text();
                int i=1;
                for (Element r : rows) {
                    Elements columns = r.select("td");
                    objArr[i++] = columns.get(1).text();
                }
                fac.add(objArr);
            }
        }
        addFacultyData();

        System.out.println("Tag Info and Faculty info filled successfully!!");
    }
}
