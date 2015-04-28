package com.richard.memorystore.udp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Gary Russell
 *
 */
@Service
public class Accumulator {

    @Transactional
    public void accumulate(SharkQuote quote) {
        System.out.println("Accumlating");
//        LoanShark shark = null;
//        try {
//            shark = (LoanShark) LoanShark.findLoanSharksByName(
//                    quote.getSharkName()).getSingleResult();
//        } catch (DataAccessException dae) {}
//        if (shark == null) {
//            shark = new LoanShark();
//            shark.setName(quote.getSharkName());
//            shark.setCounter(new Long(0));
//            shark.setAverageRate(0.0d);
//            shark.persist();
//        }
//        Double current = shark.getCounter() * shark.getAverageRate();
//        shark.setCounter(shark.getCounter().longValue() + 1);
//        shark.setAverageRate((current + quote.getSharkRate()) / shark.getCounter());
    }
    
    public void accumulate(byte[] in) {
        System.out.println("Got message: " + new String(in));
        
//        return "Got you";
    }
    
}