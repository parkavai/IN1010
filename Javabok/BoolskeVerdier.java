  class BoolskeVerdier
  {
        public static void main(String[] args)
        {
            boolean sann = true;
            boolean usann = false;

            if (sann != usann)
            {
                System.out.println("Første test slo til!");
            }
            else
            {
                System.out.println("Noe gikk feil!");
            }

            if (sann == usann)
            {
                System.out.println("Noe gikk feil!");
            }
            else
            {
                System.out.println("Andre test slo ikke til!");
            }
        }
   }
