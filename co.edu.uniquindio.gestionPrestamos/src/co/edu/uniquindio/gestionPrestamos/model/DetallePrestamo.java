package co.edu.uniquindio.gestionPrestamos.model;

import java.util.ArrayList;

/**
 * Representa del detalle del prestamo
 * @author santi, juan, nodier.
 *
 */
public class DetallePrestamo {

    private int borrowedUnits;
    private double subTotal;
    private ArrayList<Objeto> loanedProduct1 = new ArrayList<>();
    private Objeto loanedProduct;
    
    /*
     * Constructor
     * @param borrowedUnits
     * @param subTotal
     * @param loanedProduct
     */
    public DetallePrestamo(int borrowedUnits, double subTotal, ArrayList<Objeto> loanedProduct1) {
        super();
        this.borrowedUnits = borrowedUnits;
        this.subTotal = subTotal;
        this.loanedProduct1 = loanedProduct1;
    }
    
    /**
     * Constructor2
     * @param borrowedUnits
     * @param subTotal
     */
    public DetallePrestamo(int borrowedUnits, double subTotal) {
        super();
        this.borrowedUnits = borrowedUnits;
        this.subTotal = subTotal;
    }
    
    //Getters y setters
    public int getBorrowedUnits() {
        return borrowedUnits;
    }
    
    public void setBorrowedUnits(int borrowedUnits) {
        this.borrowedUnits = borrowedUnits;
    }
    
    public double getSubTotal() {
        return subTotal;
    }
    
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    public ArrayList<Objeto> getLoanedProduct1() {
        return loanedProduct1;
    }
    
    public void setLoanedProduct1(ArrayList<Objeto> loanedProduct1) {
        this.loanedProduct1 = loanedProduct1;
    }
    
    public Objeto getLoanedProduct() {
		return loanedProduct;
	}
    
	public void setLoanedProduct(Objeto loanedProduct) {
		this.loanedProduct = loanedProduct;
	}
	@Override
    public String toString() {
        return "LoanDetail [borrowedUnits=" + borrowedUnits + ", subTotal=" + subTotal + ", loanedProduct="
                + loanedProduct + "]";
    }

}

