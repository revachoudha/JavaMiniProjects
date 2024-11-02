// Source code is decompiled from a .class file using FernFlower decompiler.
class MailingAddress {
   private String street;
   private String city;
   private String state;
   private String zipCode;

   public MailingAddress() {
      this.street = " ";
      this.city = " ";
      this.state = " ";
      this.zipCode = " ";
   }

   public MailingAddress(String s, String c, String st, String zc) {
      this.street = s;
      this.city = c;
      this.state = st;
      this.zipCode = zc;
   }

   public String getAdd() {
      return this.street + "\n" + this.city + ", " + this.state + " " + this.zipCode;
   }
}
