package com.autentia.tutoriales.springbatch.jobs.fileProcessor.processor;

import com.autentia.tutoriales.springbatch.jobs.fileProcessor.model.OtroElemento;
import com.autentia.tutoriales.springbatch.jobs.fileProcessor.model.ElementMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ElementoProcessor implements ItemProcessor<ElementMapper, OtroElemento> {


   // @Override ElementProcessor
    public OtroElemento process(ElementMapper element) throws Exception {
        final String anotherElementId = element.getId() + "::" + element.getText();
        return new OtroElemento(anotherElementId);
    }
}
