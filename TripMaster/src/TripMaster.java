import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;


/*******************************************************************************

'Programmer: Karvel T Washington   
'Date: 11 02 2024
'Description:    
'    
'   This program is meant to calculate expense for a business trip per day
' 	This program calculates reimbursements and allowance for business man
'	This program takes double and integer inputs only  
'
0........1.........2.........3.........4.........5.........6.........7.........8
12345678901234567890123456789012345678901234567890123456789012345678901234567890
*/

public class TripMaster extends JFrame implements ActionListener  {
	
	
		//amount of reimbursement parking fee
		final double PARKING_REM = 10.00;
		//amount of taxi fee reimbursement
		final double TAXI_REM = 20.00;
		// amount of lodging fee reimbursement 
		final double LOD_REM = 95.40;
		// amount of miles reimbursement
		final double MILES_REM = .27;
		// amount of meals reimbursement 
		final double MEAL = 37;
	
	//creates Label for for every parameter need
	JLabel TotalExpense = new JLabel("Expense:");
	JLabel TotalAllowed = new JLabel("Total Allowance:");
	JLabel ExcessDue = new JLabel("You Owe:");
	JLabel reimbursement = new JLabel("Reimbursement:");
	JLabel NumOfDaysLabel = new JLabel("Days on Trip: ");
	JLabel AirFareFeeLabel = new JLabel("Airfare amount: {format $} ");
	JLabel CarRentalFeeLabel = new JLabel("Car rental fee: {format $} ");
	JLabel ParkingFeeLabel  = new JLabel("Parking Fee: {format $} ");
	JLabel MilesDrivenLabel = new JLabel("Miles Driven: ");
	JLabel TaxiFeeLabel = new JLabel("Taxi Fee: {format $} ");
	JLabel RegFeeLabel = new JLabel("Registration Fee: {format $} ");
	JLabel LodgeChargeLabel = new JLabel("Lodging Charge: {format $}");
	
	//created calculation button
	JButton Calc = new JButton("Calculate:");
	
	//creates text field
	JFormattedTextField TotalAllowedField;
	JFormattedTextField TotalExpenseField;
	JFormattedTextField ExcessDueField;
	JFormattedTextField reimbursementField;
	JFormattedTextField NumOfDaysField;
	JFormattedTextField AirfareFeeField;
	JFormattedTextField CarRentalFeeField;
	JFormattedTextField parkingFeesField;
	JFormattedTextField MileSDrivenField;
	JFormattedTextField TaxiFeesField;
	JFormattedTextField RegistrationFeesField;
	JFormattedTextField LodgeChargeField;
	
		// format for all currency
	   	NumberFormat currencyFormat = null;
	      
	      // Format for the miles and days input
	      NumberFormat integerFormat = null;
	
	public TripMaster() {
		
	//title of program
	setTitle("Trip Expense");	
		
	//Creates Currency format
	currencyFormat = NumberFormat.getCurrencyInstance();
	
	//Creates text field for Total Expense 
	 TotalExpenseField = new JFormattedTextField(currencyFormat);
	TotalExpenseField.setValue(0);
	TotalExpenseField.setColumns(10);
	TotalExpenseField.setEditable(true);
	TotalExpenseField.setText("");
	
	//Creates text field for total allow for business 
	 TotalAllowedField = new JFormattedTextField(currencyFormat);
	TotalAllowedField.setValue(0);
	TotalAllowedField.setColumns(10);
	TotalAllowedField.setEditable(true);
	TotalAllowedField.setText("");
	
	//Creates text field for amount owed 
	 ExcessDueField = new JFormattedTextField(currencyFormat);
	ExcessDueField.setValue(0);
	ExcessDueField.setColumns(10);
	ExcessDueField.setEditable(true);
	ExcessDueField.setText("");
	
	//Creates text field for amount due 
	 reimbursementField = new JFormattedTextField(currencyFormat);
	reimbursementField.setValue(0);
	reimbursementField.setColumns(10);
	reimbursementField.setEditable(true);
	reimbursementField.setText("");
	
	
	//Creates text field for Number of Days on trip
	integerFormat = NumberFormat.getIntegerInstance();
	 NumOfDaysField = new JFormattedTextField(integerFormat);
	NumOfDaysField.setValue(0);
	NumOfDaysField.setColumns(10);
	NumOfDaysField.setEditable(true);
	NumOfDaysField.setText("");
	
	//Creates text field for Air fare Fee 
	 AirfareFeeField = new JFormattedTextField(currencyFormat);
	AirfareFeeField.setValue(0);
	AirfareFeeField.setColumns(10);
	AirfareFeeField.setEditable(true);
	AirfareFeeField.setText("");
	
	//Creates text field for Car rental fee
	 CarRentalFeeField = new JFormattedTextField(currencyFormat);
	CarRentalFeeField.setValue(0);
	CarRentalFeeField.setColumns(10);
	CarRentalFeeField.setEditable(true);
	CarRentalFeeField.setText("");
	
	//Creates text field for amount parking Fees  
	 parkingFeesField = new JFormattedTextField(currencyFormat);
	parkingFeesField.setColumns(10);
	parkingFeesField.setValue(0);
	parkingFeesField.setEditable(true);
	parkingFeesField.setText("");
	
	
	// creates int instance for days and miles
	integerFormat = NumberFormat.getIntegerInstance();
	
	//Creates text field for amount of miles driven 
	 MileSDrivenField = new JFormattedTextField(integerFormat);
	MileSDrivenField.setValue(0);
	MileSDrivenField.setColumns(10);
	MileSDrivenField.setEditable(true);
	MileSDrivenField.setText("");
	
	
	
	// creates text field for Taxi fees
	 TaxiFeesField = new JFormattedTextField(currencyFormat);
	TaxiFeesField.setColumns(10); // Initial width of 10 units
	TaxiFeesField.setValue(0);
	TaxiFeesField.setEditable(true);
	TaxiFeesField.setText("");
	
	//Creates text field for amount of registration fees ;
	 RegistrationFeesField = new JFormattedTextField(currencyFormat);
	RegistrationFeesField.setColumns(10); // Initial width of 10 units
	RegistrationFeesField.setValue(0);
	RegistrationFeesField.setEditable(true);
	RegistrationFeesField.setText("");
	
	//Creates text field for amount of Lodging 
	  LodgeChargeField = new JFormattedTextField (currencyFormat);
	LodgeChargeField.setEditable(true);
	LodgeChargeField.setValue(0);
	LodgeChargeField.setColumns(10);
	LodgeChargeField.setText("");
	
	
	
	//set layout object 
	setLayout(new GridBagLayout());
	GridBagConstraints layoutConst = null;
    layoutConst = new GridBagConstraints();
    
	
    //adds TotalExpense TextField to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 15;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TotalExpenseField, layoutConst);
	
    //adds TotalAllowed TextField to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 13;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TotalAllowedField, layoutConst);
    
    //ADDS ExcessDue TextField to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 10;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(ExcessDueField, layoutConst);
    
    //Adds reimbursement TextField to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(reimbursementField, layoutConst);
    
    //Adds TotalExpense Label to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 14;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TotalExpense, layoutConst);
    
    //Adds TotalAllowed  Label to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 12;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TotalAllowed, layoutConst);
    
    //Adds ExcessDue Label to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 6;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(ExcessDue, layoutConst);
    
    //Adds reimbursement Label to screen 
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 0;
    layoutConst.gridy = 50;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(reimbursement, layoutConst);
  
    //Adds lodge label to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 10;
    layoutConst.gridy = 18;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(LodgeChargeLabel, layoutConst); 
    
    //adds Lodge field to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 11;
    layoutConst.gridy = 18;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(LodgeChargeField, layoutConst);
    
    //add registration fee label to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 10;
    layoutConst.gridy = 17;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(RegFeeLabel, layoutConst); 
    
    //add registration fees text field to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 11;
    layoutConst.gridy = 17;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(RegistrationFeesField, layoutConst);
    
    //add taxi fee label to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 10;
    layoutConst.gridy = 15;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TaxiFeeLabel, layoutConst); 
    
    //add Taxi field to screen
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 11;
    layoutConst.gridy = 15;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(TaxiFeesField, layoutConst);
    
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 10;
    layoutConst.gridy = 14;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(MilesDrivenLabel, layoutConst); 
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 11;
    layoutConst.gridy = 14;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(MileSDrivenField, layoutConst);
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 0;
    layoutConst.gridy = 18;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(ParkingFeeLabel, layoutConst); 
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 18;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(parkingFeesField, layoutConst);
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 0;
    layoutConst.gridy = 14;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(NumOfDaysLabel, layoutConst); 
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 14;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(NumOfDaysField, layoutConst);
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 0;
    layoutConst.gridy = 15;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(AirFareFeeLabel, layoutConst); 
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 15;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(AirfareFeeField, layoutConst);
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 0;
    layoutConst.gridy = 17;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(CarRentalFeeLabel, layoutConst); 
    
    layoutConst = new GridBagConstraints();
    layoutConst.gridx = 1;
    layoutConst.gridy = 17;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(CarRentalFeeField, layoutConst);
    
    
    
    
  //creates Calculation button and position on bottom
    Calc = new JButton("Calculate");
    Calc.addActionListener(this);
    layoutConst.gridx = 14;
    layoutConst.gridy = 15;
    layoutConst.insets = new Insets(10, 10, 10, 10);
    add(Calc, layoutConst);
    
	}
	
	
	public void actionPerformed(ActionEvent event) {
  
		//calls method that does all calculations 
		 CostOfTrip(AirfareFeeField,CarRentalFeeField,parkingFeesField,TaxiFeesField,
					RegistrationFeesField,LodgeChargeField,MileSDrivenField, NumOfDaysField );
	
      
          
	}      
	
	public  void  CostOfTrip(JFormattedTextField airfare, JFormattedTextField carRentals,
		JFormattedTextField parkingFees, JFormattedTextField taxis, JFormattedTextField regist,
		JFormattedTextField lodging, JFormattedTextField mile, JFormattedTextField day ) {
		
		
		//TODO: Check calculations and variable names 
		 
		// write comments 
		
	  	//Days on trip
	  	double days = 0 ;
	  	//cost of Air fare
		double airfares = 0 ;
		//Cost of car rental 
		double carRental = 0;
		// amount of miles driven
		double miles = 0;
		//cost of parking fee
		double parkingFee = 0;
		// cost of taxi fee
		double taxi = 0;
		// cost of registration fee
		double reg = 0;
		// cost of lodging
		double Lod = 0;
		// total amount of all expenses
		double total = 0;
		//amount saved from reimbursement
		double saved = 0;
		// total of reimbursement
		double rem = 0;
		//amount of allowance for trip
		double allowedTrip = 0;
		//amount the client gets back ( reimbursement ) 
		double moneyback = 0;
		// string field that holds allowance
		String Allowedtotals = "" ;
		// string total that holds excess amount owed to client
		String excess = ""; 
		// string totals for expenses
		String totals = "" ;
		
		
		//converts textField string into a Interger 
		days = ((Number) day.getValue()).intValue();
		
		//Calculates reimbursement by company paid meal times the day on the trip
		rem = MEAL * days;
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		if (airfare != null)
		{
			airfares = ((Number)airfare.getValue()).doubleValue();	
		}
		//else set textField  to 0
		else 
		{
			
			AirfareFeeField.setText("0");	
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		if (carRentals != null)
		{
			carRental = ((Number)carRentals.getValue()).doubleValue();	
		}
		//else set textField to 0
		else 
		{
			 CarRentalFeeField.setText("0");	
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		// adds parking allowance to variable "rem" if field is not null
		if (parkingFees != null) {
			parkingFee = ((Number)parkingFees.getValue()).doubleValue();
			rem = rem +(PARKING_REM*days);
			
		}
		//else set textField  to 0
		else 
		{
			parkingFeesField.setText("0");	
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		// adds taxi allowance to variable "rem" if field is not null
		if (taxis != null) {
			taxi = ((Number)taxis.getValue()).doubleValue();
			rem = rem +(TAXI_REM*days);
			
		}
		//else set textField  to 0
		else 
		{
			TaxiFeesField.setText("0");	
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		if (regist != null) {
			reg = ((Number)regist.getValue()).doubleValue();
			
		}
		//else set textField  to 0
		else 
		{
			RegistrationFeesField.setText("0");	
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		// adds lodging allowance to variable "rem" if field is not null
		if (lodging != null)
		{
			Lod = ((Number)lodging.getValue()).doubleValue();
			rem = rem + (LOD_REM*days);	
		}
		//else set textField  to 0
		else 
		{
			LodgeChargeField.setText("0");		
		}
		
		
		//checks if textFeild is null then converts String textField into Integer and stores it in variable 
		// adds miles allowance to variable "rem" if field is not null
		if (mile != null) 
		{
			rem = rem + (MILES_REM*miles);
			miles = ((Number)mile.getValue()).doubleValue();
		}
		else 
		{
			
			MileSDrivenField.setText("0");	
		}
		
		
		//calculates the total amount owed for trip 
		total = (airfares + carRental + parkingFee + taxi + reg + Lod + miles ) * days;
		//calculates the total amount covered by company for client   
		allowedTrip = (PARKING_REM + TAXI_REM + LOD_REM+ MILES_REM +MEAL)*days;
		//Calculates total saved on trip from amount paid by company 
		saved = total - rem;
		
		
		//outputs to textField amount saved on trip
		if (saved>0) 
		{
			//converts to string with .2 decimal places
			excess = String.format("%.2f",saved);
			ExcessDueField.setText(excess);
		}
		//sets textField to 0 otherwise
		else 
		{
			ExcessDueField.setText("0.00");
		}
		
		
		//calculates amount reimbursed to client 
		moneyback = allowedTrip - total;
		
		//outputs zero to screen if there's no reimbursement 
		if(moneyback<0)
		{
			reimbursementField.setText("0");
		}
		//else converts amount by .2 decimal places to string
		else 
		{
			String money = String.format("%.2f", moneyback);
			reimbursementField.setText(money);
		}
		
		
		
		//convert total expense amount to string by 2 decimal places
	    totals = String.format("%.2f",total);
		TotalExpenseField.setText(totals);
		
		//convert total company paid expense to string by 2 decimal places
		Allowedtotals = String.format("%.2f",allowedTrip);
		TotalAllowedField.setText(Allowedtotals);
	}
	
        
	
	

	
	  public static void main(String[] args) {
		   
		   TripMaster myFrame = new TripMaster();

		      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      myFrame.pack();
		      myFrame.setVisible(true);
		 
		   
	     
	   }
	

}
