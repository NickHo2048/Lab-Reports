import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSingleImage() throws IOException {
        String contents= Files.readString(Path.of("./test-single-image.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testLinkAtBeginning() {
        String contents= "[link title](a.com)";
        List<String> expect = List.of("a.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceInURL() {
        String contents = "[title](space in-url.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSpaceBeforeParen() {
        String contents = "[title]   (should-not-count.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testSnippet1() throws IOException
    {
        String contents = readFile("snippet-1.md");
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> Reallinks = new ArrayList<>(List.of("url.com","`google.com","google.com", "ucsd.edu"));
        assertArrayEquals(Reallinks.toArray(),links.toArray());
    }

    @Test 
    public void testSnippet2() throws IOException
    {
        String contents = readFile("snippet-2.md");
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> Reallinks = new ArrayList<>(List.of("a.com","b.com","a.com(())", "example.com"));
        assertArrayEquals(Reallinks.toArray(),links.toArray());
    }

    @Test
    public void testSnippet3() throws IOException
    {
        String contents = readFile("snippet-3.md");
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> Reallinks = new ArrayList<>(List.of("https://www.twitter.com","https://ucsd-cse15l-w22.github.io/","https://cse.ucsd.edu/"));
        assertArrayEquals(Reallinks.toArray(),links.toArray());
    }
}
/*import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("./test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks1() throws IOException{
        Path fileName = Path.of("./test2-file.md");
	    String contents = Files.readString(fileName);
        assertEquals( List.of("link.com"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinks2() throws IOException{
        Path fileName = Path.of("./test3-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("link.com"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinks3() throws IOException{
        Path fileName = Path.of("./test4-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
   
}*/

