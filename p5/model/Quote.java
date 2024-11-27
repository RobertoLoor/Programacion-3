package es.ua.dlsi.prog3.p5.model;

import java.util.List;

import es.ua.dlsi.prog3.p5.export.IExporter;

public class Quote extends Paragraph {
    public Quote(List<IParagraphContent> paragraphContentList) {
        super(paragraphContentList);
    }

    public Quote(IParagraphContent... contents) {
        super(contents);
    }

    @Override
    public String export(IExporter exporter) {
        return exporter.export(this);
    }
}