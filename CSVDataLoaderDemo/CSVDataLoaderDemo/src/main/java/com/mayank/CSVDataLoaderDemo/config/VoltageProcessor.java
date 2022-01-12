package com.mayank.CSVDataLoaderDemo.config;

import com.mayank.CSVDataLoaderDemo.dao.Voltage;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VoltageProcessor implements ItemProcessor<Voltage, Voltage> {

    @Override
    public Voltage process(Voltage voltage) throws Exception {
        final BigDecimal volt = voltage.getVolt();
        final double time = voltage.getTime();

        final Voltage processedVoltage = new Voltage();
        processedVoltage.setVolt(volt);
        processedVoltage.setTime(time);
        return processedVoltage;
    }
}
