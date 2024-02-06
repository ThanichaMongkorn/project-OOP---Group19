//package Parser;
//
//import Token.Tokenizer;
//
//import java.io.*;
//import java.nio.charset.*;
//import java.nio.file.*;
//import java.util.NoSuchElementException;
//
//import static java.nio.file.StandardOpenOption.*;
//
//public class ReadWrite {
//    public static void read(String path){
//        Path file = Paths.get(path),ans = Paths.get("src/TestAns.txt");  // path string
//        Charset charset = StandardCharsets.UTF_8;
//        try (BufferedReader reader =
//                     Files.newBufferedReader(file, charset)) {
//            String line = null;
//            Files.write(ans,"".getBytes());
//            while ((line = reader.readLine()) != null) {
//                try{
//                    write(line,computeLine(line));
//                }catch (SyntaxError | ArithmeticException | NoSuchElementException e){
//                    System.out.println(e.getMessage() + " line " + line);
//                }
//            }
//        } catch (IOException x) {
//            System.err.println("IOException");
//        }
//    }
//    private static void write(String line, int Ans){
//        String s = " = ";
//        Path ans = Paths.get("src/TestAns.txt");
//        Charset charset = StandardCharsets.UTF_8;
//        try (OutputStream out = new BufferedOutputStream(
//                Files.newOutputStream(ans, CREATE, APPEND))) {
//            String result = line + s + Ans + System.lineSeparator();
//            out.write(result.getBytes(charset));
//        } catch (IOException x) {
//            System.err.println(x.getMessage());
//        }
//    }
//    public static int computeLine(String line) throws SyntaxError{
//        Tokenizer tkz = new Tokenizer(line);
//        ParserCalculate p = new ParserCalculate(tkz);
//        return p.parse();
//    }
//
//}
