package cashregister;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        Printer printer=mock(Printer.class);
        Purchase purchase=new Purchase(new Item[]{ new Item("a",12) });
        CashRegister cashRegister=new CashRegister(printer);
        cashRegister.process(purchase);

        verify(printer).print("a\t12.0\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        Printer printer=mock(Printer.class);
        Purchase purchase=mock(Purchase.class);
        CashRegister cashRegister=new CashRegister(printer);
        //when
        when(purchase.asString()).thenReturn("haha");
        cashRegister.process(purchase);
        //then

        verify(printer).print("haha");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        Printer printer=mock(Printer.class);
        CashRegister cashRegister=new CashRegister(printer);

        //when
        cashRegister.process(new Purchase(new Item[]{}));

        //then

        verify(printer).print("");
    }

}
