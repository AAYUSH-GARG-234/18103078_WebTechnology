import java.util.*;
import java.util.Scanner;
import java.lang.Math.*;
import java.util.HashSet;
import java.util.Set;

public class ques1 {
    public static void main(String[] args){
        int n,m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextline();

        String[] crop = new String[n];
        for (int i=0;i<n;i++) {
            crop[i] = in.nextLine().trim();
        }
        char[][] crop_mat = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++) {
                crop_mat[i][j] = crop[i].charAt(j);
            }
        }

        String crop_variety = "abcdefghijklmnopqrstuvwxyz";

        System.out.print("Minimum plots to plant are: ");
        System.out.println(plant(crop_mat, 0, 0, n, m, 0, n*m, crop_variety));
    }

    public static int plant(char[][] crop_mat, int current_row, int current_column, int n, int m, int current_cost, int min_cost, String crop_variety) {
        Set<Character> upLeft = new HashSet<>();
        if(current_row != 0){
            upLeft.add(crop_mat[current_row-1][current_column]);
        }
        if(current_column != 0){
            upLeft.add(crop_mat[current_row][current_column-1]);
        }

        Set<Character> downRight = new HashSet<>();
        if(current_row!=n-1){
            downRight.add(crop_mat[current_row+1][current_column]);
        }
        if(current_column!=m-1){
            downRight.add(crop_mat[current_row][current_column+1]);
        }

        boolean present_left_up = false;
        if(upLeft.contains(crop_mat[current_row][current_column])) {
            present_left_up = true;
        }

        char[][] new_crop_mat = new char[n][m];
        if(downRight.contains(crop_mat[current_row][current_column])) {

            if(present_left_up){

                for(int k=0; k<26; k++) {
                    if(!upLeft.contains(crop_variety.charAt(k)) && !downRight.contains(crop_variety.charAt(k))) {
                        for(int i=0; i<n; i++) {
                            if (m >= 0) System.arraycopy(crop_mat[i], 0, new_crop_mat[i], 0, m);
                        }
                        new_crop_mat[current_row][current_column] = crop_variety.charAt(k);

                        if(current_column<m-1) {
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else if(current_row<n-1) {
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row+1, 0, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else {
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }
            }
            else{

                if(current_column<m-1){
                    min_cost = Math.min(min_cost, plant(crop_mat, current_row, current_column+1, n, m, current_cost, min_cost, crop_variety));
                }
                else if(current_row<n-1) {
                    min_cost = Math.min(min_cost, plant(crop_mat, current_row+1, 0, n, m, current_cost, min_cost, crop_variety));
                }
                else {
                    return Math.min(current_cost, min_cost);
                }
                for(int k=0; k<26;k++){
                    if(!upLeft.contains(crop_variety.charAt(k)) && !downRight.contains(crop_variety.charAt(k))){
                        for(int i=0; i<n; i++) {
                            if (m >= 0) System.arraycopy(crop_mat[i], 0, new_crop_mat[i], 0, m);
                        }
                        new_crop_mat[current_row][current_column] = crop_variety.charAt(k);
                        if(current_column<m-1) {
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else if(current_row<n-1) {
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row+1, 0, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else {
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }

            }
        }
        else{

            if(present_left_up) {

                for(int k=0; k<26;k++){
                    if(!upLeft.contains(crop_variety.charAt(k)) && !downRight.contains(crop_variety.charAt(k))){
                        for(int i=0; i<n; i++){
                            if (m >= 0) System.arraycopy(crop_mat[i], 0, new_crop_mat[i], 0, m);
                        }
                        new_crop_mat[current_row][current_column] = crop_variety.charAt(k);

                        if(current_column<m-1){
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row, current_column+1, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else if(current_row<n-1){
                            min_cost = Math.min(min_cost, plant(new_crop_mat, current_row+1, 0, n, m, current_cost+1, min_cost, crop_variety));
                        }
                        else{
                            return Math.min(current_cost+1, min_cost);
                        }
                        break;
                    }
                }
            }
            else {

                if(current_column<m-1) {
                    min_cost = Math.min(min_cost, plant(crop_mat, current_row, current_column+1, n, m, current_cost, min_cost, crop_variety));
                }
                else if(current_row<n-1) {
                    min_cost = Math.min(min_cost, plant(crop_mat, current_row+1, 0, n, m, current_cost, min_cost, crop_variety));
                }
                else {
                    return Math.min(current_cost, min_cost);
                }
            }
        }
        return min_cost;
    }
}
