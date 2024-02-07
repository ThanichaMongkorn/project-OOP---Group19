import Parser.ParserCalculate;
import Parser.SyntaxError;
import Plan.ClassPlan;
import Token.Tokenizer;

    public class Main {
        public static void main(String[] args) {
            testParserCalculate();
        }

        public static void testParserCalculate() {
            String input = "{ move up ; move downleft ; shoot down ; }";

            // Create a tokenizer and parser
            Tokenizer tokenizer = new Tokenizer(input);
            ParserCalculate parser = new ParserCalculate(tokenizer);

            try {
                // Parse the input
                ClassPlan parsedPlan = (ClassPlan) parser.parse();

                // Output the parsed plan
                System.out.println("Parsed plan: " + parsedPlan);
            } catch (SyntaxError e) {
                // Handle syntax error
                System.err.println("Syntax error: " + e.getMessage());
            }
        }
    }


