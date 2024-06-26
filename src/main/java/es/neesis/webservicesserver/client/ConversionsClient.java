package es.neesis.webservicesserver.client;

import es.neesis.webservicesserver.ws.numbers.NumberToDollars;
import es.neesis.webservicesserver.ws.numbers.NumberToDollarsResponse;
import es.neesis.webservicesserver.ws.numbers.NumberToWords;
import es.neesis.webservicesserver.ws.numbers.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConversionsClient extends WebServiceGatewaySupport {

    public NumberToDollarsResponse numberToDollars(double number){
        NumberToDollars request = new NumberToDollars();
        request.setDNum(BigDecimal.valueOf(number));

        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public NumberToWordsResponse numberToWords(int number){
        NumberToWords request = new NumberToWords();
        request.setUbiNum(new BigInteger(String.valueOf(number)));

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
