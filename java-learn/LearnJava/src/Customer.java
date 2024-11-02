// Source code is decompiled from a .class file using FernFlower decompiler.
class Customer {
   private String last_Name;
   private String first_Name;
   private String carMake;
   private String carModel;
   private String carLicensePlate;
   private double deposit;
   private String reference = "";
   public MailingAddress address;

   public Customer(String ln, String fn, String cMa, String cMo, String lp, Double de) {
      this.last_Name = ln;
      this.first_Name = fn;
      this.carMake = cMa;
      this.carModel = cMo;
      this.carLicensePlate = lp;
      this.address = new MailingAddress();
      this.deposit = de;
   }

   public String getLN() {
      return this.last_Name;
   }

   public void setLN(String ln) {
      this.last_Name = ln;
   }

   public String getFN() {
      return this.first_Name;
   }

   public void setFM(String fn) {
      this.first_Name = fn;
   }

   public String getMake() {
      return this.carMake;
   }

   public void setMake(String ma) {
      this.carMake = ma;
   }

   public String getModel() {
      return this.carModel;
   }

   public void setModel(String mo) {
      this.carModel = mo;
   }

   public Double getDeposit() {
      return this.deposit;
   }

   public void setDeposit(Double d) {
      this.deposit = d;
   }

   public String getLicensePlate() {
      return this.carLicensePlate;
   }

   public void setLicensePlate(String lp) {
      this.carLicensePlate = lp;
   }

   public void setReferenceTicket(String d) {
      this.reference = d;
   }

   public String getReferenceTicket() {
      return this.reference;
   }

   public String toString() {
      String var10000 = this.getClass().getName();
      return var10000 + "[ " + this.getFN() + " " + this.getLN() + "\n" + this.getMake() + " " + this.getModel() + "\n" + this.getLicensePlate() + "\n" + this.getDeposit() + "]";
   }
}
