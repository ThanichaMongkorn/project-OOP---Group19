//package Parser;
//
//
//
//public class Main {
//    public static void main(String[] args) {
//        // Example input
//        String input = "{ done = 123 ; move up ; if ( nearby up ) then { shoot up 5 ; } else { collect 10 ; } }";
//
//        // Create tokenizer
//        Tokenizer tokenizer = new Tokenizer(input);
//
//        try {
//            // Create parser with tokenizer
//            ParserCalculate parser = new ParserCalculate(tokenizer);
//
//            // Parse the input
//            Plan plan = parser.parse();
//
//            // Output the parsed plan
//            System.out.println(plan.toString());
//        } catch (SyntaxError e) {
//            // Handle syntax error
//            System.out.println("Syntax Error: " + e.getMessage());
//        }
//    }
//}
