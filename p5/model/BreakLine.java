package es.ua.dlsi.prog3.p5.model;

import es.ua.dlsi.prog3.p5.export.IExporter;


///// IMPLEMENTADO---------------------------
public class BreakLine extends Paragraph implements IParagraphContent {
    @Override
    public String export(IExporter exporter) {
        return exporter.export(this);
    }
}