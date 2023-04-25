package org.example;

import database.DatabaseQueryService;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new DatabaseQueryService().findMaxSalary().toString());
        System.out.println(new DatabaseQueryService().findMaxProjectCountClient().toString());
        System.out.println(new DatabaseQueryService().findLongestPrices().toString());
        System.out.println(new DatabaseQueryService().findYoungOldWorker().toString());
        System.out.println(new DatabaseQueryService().printProjectPrice().toString());
    }
}
