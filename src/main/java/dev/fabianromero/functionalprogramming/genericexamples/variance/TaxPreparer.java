package dev.fabianromero.functionalprogramming.genericexamples.variance;

import java.util.ArrayList;
import java.util.List;

public class TaxPreparer {

    public boolean prepareBulkTaxes(List<? extends Taxable> taxables) {
        for (Taxable taxable : taxables) {
            prepareTaxes(taxable);
        }
        return true;
    }

    private void prepareTaxes(Taxable taxable) {
        System.out.println("Preparing taxes of " + taxable.getFinancialStatement());
    }
}
