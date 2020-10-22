package BankersAlgorithm;

import java.util.Scanner;

public class BankersAlgorithm {
    private static int resources;
    private static int processes;
    private static int[] CalculateAllocatedTotal(int[][] SumResources) {
        int[] Total  = new int[resources];
        for (int i = 0; i < resources; i++) {
            Total[i] = 0;
            for (int j = 0; j < processes; j++) {
                Total[i] += SumResources[j][i]; 
            }
        }
        return Total;
    }
    private static int[] CalculateAvailableVector(int[] MaxClaim, int[] AllocatedTotal) {
        int[] Total  = new int[resources];
        for (int i = 0; i < resources; i++) {
            Total[i] = MaxClaim[i] - AllocatedTotal[i];
        }
        return Total;
    }
    
    private static int[][] CalculateClaimsAllocations(int[][] MaxClaim, int[][] AllocatedTotal) {
        int[][] need = new int[processes][resources];
        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                need[i][j] = MaxClaim[i][j] - AllocatedTotal[i][j]; 
            }
        }
        return need;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 30; i++) System.out.print("*");
        System.out.println("\ncreated by thabang makhubo");
        for (int i = 0; i < 30; i++) System.out.print("*");
        System.out.print("\nEnter number of resources (i.e. 3): ");
        resources = in.nextInt();
        System.out.print("Enter number of processes (i.e. 3): ");
        processes = in.nextInt();
        System.out.println("\nEnter total resources:");
        int[] TotalResource = new int[resources];
        int count = 1;
        for (int i = 0; i < TotalResource.length; i++) {
            System.out.printf("Enter R%d: ",count);
            TotalResource[i] = in.nextInt();
        }
        System.out.println("\nTotal Resource:");
        for (int i = 0; i < TotalResource.length; i++) {
            if(i > 0){
                System.out.printf("%3s%d","R",(i));
            } else {
                System.out.printf("%3s","");
            }
        }
        System.out.println("");
        for (int i : TotalResource) System.out.printf("%3s",i);
        
        int[][] Allocation = new int[processes][resources];
        System.out.println("\n\nAllocation:");
        for (int i = -1; i < processes; i++) {
            if(i == -1) {
                for (int j = 0; j < TotalResource.length; j++) {
                    if(j > 0){
                        System.out.printf("%3s%d","R",(j));
                    } else {
                        System.out.printf("%3s","");
                    }
                }
                System.out.println("");
            } else {
                System.out.printf("P%s: ", i + 1);
                for (int j = 0; j < resources; j++) {
                    System.out.printf("%3s",Allocation[i][j]);
                }
                System.out.println("");
            }
        }
        int[][] Claim = new int[processes][resources];
        System.out.println("\nClaim:");
        for (int i = -1; i < processes; i++) {
            if(i == -1) {
                for (int j = 0; j < TotalResource.length; j++) {
                    if(j > 0){
                        System.out.printf("%3s%d","R",(j));
                    } else {
                        System.out.printf("%3s","");
                    }
                }
                System.out.println("");
            } else {
                System.out.printf("P%s: ", i + 1);
                for (int j = 0; j < resources; j++) {
                    System.out.printf("%3s",Claim[i][j]);
                }
                System.out.println("");
            }
        }
        
        int[] AllocatedTotal = CalculateAllocatedTotal(Allocation);
        System.out.println("\nAllocated Total:");
        for (int j = 0; j < TotalResource.length; j++) {
            if(j > 0){
                System.out.printf("%3s%d","R",(j+1));
            } else {
                System.out.printf("%3s","");
            }
        }
        System.out.println("");
        for (int i : AllocatedTotal) System.out.printf("%3s",i);
        
        int[] AvailableVector = CalculateAvailableVector(TotalResource, AllocatedTotal);
        System.out.println("\n\nAvailable Vector:");
        for (int j = 0; j < TotalResource.length; j++) {
            if(j > 0){
                System.out.printf("%3s%d","R",(j));
            } else {
                System.out.printf("%3s","");
            }
        }
        System.out.println("");
        for (int i : AvailableVector) System.out.printf("%3s",i);
        
        int[][] NeedMatrix = CalculateClaimsAllocations(Claim, Allocation);
        System.out.println("\n\nNeed Matrix:");
        for (int i = -1; i < processes; i++) {
            if(i == -1) {
        for (int j = 0; j < TotalResource.length; j++) {
            if(j > 0){
                System.out.printf("%3s%d","R",(j));
            } else {
                System.out.printf("%3s","");
            }
        }
        System.out.println("");
            } else {
                System.out.printf("P%s: ", i + 1);
                for (int j = 0; j < resources; j++) {
                    System.out.printf("%3s",NeedMatrix[i][j]);
                }
                System.out.println("");
            }
        }
        System.console();
    }
}