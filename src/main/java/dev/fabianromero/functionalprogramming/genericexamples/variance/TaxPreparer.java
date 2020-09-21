package dev.fabianromero.functionalprogramming.genericexamples.variance;

import com.sun.javafx.stage.WindowEventDispatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaxPreparer {

    public boolean prepareBulkTaxes(List<? extends Taxable> clients) {
        for (Taxable client : clients) {
            prepareTaxes(client);
        }
        return true;
    }

    private void prepareTaxes(Taxable client) {
        System.out.println("Preparing taxes of " + client.getFinancialStatement());
    }

    //TODO Avoid mutability - This is only an example of contra-variance
    public List<? super Individual> getIndividualClients(List<? super Individual> clients) {
        clients.add(new Individual());
        return clients;
    }
}
