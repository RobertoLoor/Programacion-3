package es.ua.dlsi.prog3.p5.client;

import es.ua.dlsi.prog3.p5.model.*;
import java.util.Arrays;

public class ExampleDocumentCreator {
    /**
     * Creates an example document containing various elements such as headings, paragraphs,
     * formatted text, quotes, and more.
     *
     * @return Document object
     */
    public Document createExample() {
        Document document = new Document();

        try {
            // # Heading
            Heading heading = new Heading("Heading", 1);
            document.add(heading);

            // Some text to introduce the article
            Text introText = new Text("Some text to introduce the article");
            Paragraph introParagraph = new Paragraph(introText);
            document.add(introParagraph);

            // > Something someone said:[original cite site](https://www.somesite.edu)
            Text quoteText = new Text("Something someone said:");
            LinkParagraphContentDecorator cite = new LinkParagraphContentDecorator(
                    new Text("original cite site"),
                    "https://www.somesite.edu"
            );
            Quote quote = new Quote(quoteText, cite);
            document.add(quote);

            // ## First section
            Heading sectionHeading = new Heading("First section", 2);
            document.add(sectionHeading);
            
            
            Text exampleOf = new Text ("Example of text decorators:");
            document.add(new Paragraph(exampleOf));

            // Example of text decorators
            Text rawText = new Text("Raw text");
            ItalicsTextDecorator italics
            = new ItalicsTextDecorator(new Text("Italics"));
            BoldTextDecorator bold = new BoldTextDecorator(new Text("Bold"));
            StrikeThroughDecorator strikeThrough = new StrikeThroughDecorator(new Text("Strike through"));
            ItalicsTextDecorator complex = new ItalicsTextDecorator(
                    new BoldTextDecorator(
                            new StrikeThroughDecorator(new Text("The three above"))
                    )
            );
            Text paragraphText = new Text("Raw text inside a paragraph");

            OrderedListBlock listBlock = new OrderedListBlock(
                    Arrays.asList(
                            rawText,
                            italics,
                            bold,
                            strikeThrough,
                            complex,
                            new Paragraph(paragraphText)
                    )
            );
            document.add(listBlock);

            // ### Code block
            Heading codeHeading = new Heading("Code block", 3);
            document.add(codeHeading);

            CodeBlock codeBlock = new CodeBlock("class PROG3 {}", "java");
            document.add(codeBlock);

            // -----
            HorizontalRule hr = new HorizontalRule();
            document.add(hr);

            // UA Logo
            Image uaLogo = new Image("https://web.ua.es/secciones-ua/images/layout/logo-ua.jpg", "UA logo");
            Paragraph logoParagraph = new Paragraph(uaLogo);
            document.add(logoParagraph);

        } catch (EditorException e) {
            throw new RuntimeException("Error while creating example document", e);
        }

        return document;
    }
}