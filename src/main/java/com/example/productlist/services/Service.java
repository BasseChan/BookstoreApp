package com.example.productlist.services;

import com.example.productlist.domain.*;
import com.example.productlist.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    ComplaintStateRepository complaintStateRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderStateRepository orderStateRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    Category_BookRepository category_bookRepository;
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    Author_BookRepository author_bookRepository;
//    @Autowired
//    PaymentTypeRepository paymentTypeRepository;
//    @Autowired
//    DeliveryTypeRepository deliveryTypeRepository;

    public void seed(){
        //OrderState
        OrderState orderState1  = OrderState.builder()
                .stateName("Oczekujące")
                .build();
        orderStateRepository.save(orderState1);
        OrderState orderState2  = OrderState.builder()
                .stateName("Realizacja")
                .build();
        orderStateRepository.save(orderState2);
        OrderState orderState3  = OrderState.builder()
                .stateName("Wysłane")
                .build();
        orderStateRepository.save(orderState3);
        OrderState orderState4  = OrderState.builder()
                .stateName("Anulowane")
                .build();
        orderStateRepository.save(orderState4);
        OrderState orderState5  = OrderState.builder()
                .stateName("Dostarczone")
                .build();
        orderStateRepository.save(orderState5);



        //ComplaintState
        ComplaintState complaintState1  = ComplaintState.builder()
                .stateName("Oczekująca")
                .build();
        complaintStateRepository.save(complaintState1);
        ComplaintState complaintState2  = ComplaintState.builder()
                .stateName("Zatwierdzone")
                .build();
        complaintStateRepository.save(complaintState2);
        ComplaintState complaintState3  = ComplaintState.builder()
                .stateName("Odrzucone")
                .build();
        complaintStateRepository.save(complaintState3);

        //PaymentType
//        PaymentType paymentType1 = new PaymentType().builder()
//                .typeName("BLik")
//                .build();
//        paymentTypeRepository.save(paymentType1);
//        PaymentType paymentType2 = new PaymentType().builder()
//                .typeName("Karta płatnicza")
//                .build();
//        paymentTypeRepository.save(paymentType2);
//        PaymentType paymentType3 = new PaymentType().builder()
//                .typeName("PayPal")
//                .build();
//        paymentTypeRepository.save(paymentType3);
//
//        //DeliveryType
//        DeliveryType deliveryType1 =  new DeliveryType().builder()
//                .typeName("DHL")
//                .build();
//        deliveryTypeRepository.save(deliveryType1);
//        DeliveryType deliveryType2 =  new DeliveryType().builder()
//                .typeName("Poczta Polska")
//                .build();
//        deliveryTypeRepository.save(deliveryType2);



        //Address
        Address address1 =  Address.builder()
                .country("Polska")
                .city("Wrocław")
                .zipCode("98-200")
                .street("Biskupa Tomasza Pierwszego")
                .buildingNumber("13")
                .placeNumber("5")
                .build();
        addressRepository.save(address1);
        Address address2 =  Address.builder()
                .country("Polska")
                .city("Sieradz")
                .zipCode("68-220")
                .street("Pistowska")
                .buildingNumber("1")
                .placeNumber("1")
                .build();
        addressRepository.save(address2);

        //Category
        Category category1 = Category.builder()
                .categoryName("Fantasy")
                .build();
        categoryRepository.save(category1);
        Category category2 = Category.builder()
                .categoryName("Poradnik")
                .build();
        categoryRepository.save(category2);

        //Author
        Author author1 =  Author.builder()
                .name("Brandon")
                .surname("Sanderson")
                .build();
        authorRepository.save(author1);
        Author author2 =  Author.builder()
                .surname("Polak")
                .build();
        authorRepository.save(author2);
        Author author3 =  Author.builder()
                .surname("J.R.R Tolkien")
                .build();
        authorRepository.save(author3);
        Author author4 =  Author.builder()
                .name("Robin")
                .surname("Hoob")
                .build();
        authorRepository.save(author4);

        //Payment
        Payment payment1  = Payment.builder()
                .dateOfPayment(new Date(122,12,5))
                .paymentType("Karta płatnicza")
                .paymentValue(40.0f)
                .build();
        paymentRepository.save(payment1);
        Payment payment2  = Payment.builder()
                .dateOfPayment(new Date(122,12,3))
                .paymentType("BLik")
                .paymentValue(72.0f)
                .build();
        paymentRepository.save(payment2);
        Payment payment3  = Payment.builder()
                .dateOfPayment(new Date(122,12,3))
                .paymentType("PayPal")
                .paymentValue(50.0f)
                .build();
        paymentRepository.save(payment3);
        Payment payment4  = Payment.builder()
                .dateOfPayment(new Date(122,12,4))
                .paymentType("Karta płatnicza")
                .paymentValue(60.0f)
                .build();
        paymentRepository.save(payment4);

        //Invoice
        Invoice  invoice  = Invoice.builder()
                .nip("1111111111")
                .invoiceNumber("111111")
                .invoiceValue(31.0f)
                .build();
        invoiceRepository.save(invoice);

        //Book
        Book book = Book.builder()
                .title("Z mgły  zrodzony")
                .availability(10)
                .inOffer(true)
                .description("Mgła i popiół")
                .build();
        bookRepository.save(book);
        Book book1 = Book.builder()
                .title("Królestwo  Tysiąca Włóczni")
                .availability(1)
                .inOffer(true)
                .description("Ziemia, pożoga i śmierć")
                .build();
        bookRepository.save(book1);
        Book book2 = Book.builder()
                .title("Poradnik do drewna")
                .availability(2)
                .inOffer(true)
                .description("Zapach drewna")
                .build();
        bookRepository.save(book2);
        Book book3 = Book.builder()
                .title("Skrytobójca Błazna")
                .availability(2)
                .inOffer(true)
                .description("Wspaniała przyjaźń")
                .build();
        bookRepository.save(book3);
        Book book4 = Book.builder()
                .title("Władca Pierścieni")
                .availability(2)
                .inOffer(true)
                .description("Wspaniałą przygoda  w  wielkim  fantastycznym świecie")
                .build();
        bookRepository.save(book4);
        Book book5 = Book.builder()
                .title("Z mgły zrodzony, tom II")
                .availability(2)
                .inOffer(true)
                .description("Wspaniałą przygoda  w  wielkim  fantastycznym świecie")
                .build();
        bookRepository.save(book5);

        //Category_Book
        Category_Book category_book1 = Category_Book.builder()
                .bookInCategory_Book(book)
                .categoryInCategory_Book(category1)
                .build();
        category_bookRepository.save(category_book1);
        Category_Book category_book2 = Category_Book.builder()
                .bookInCategory_Book(book1)
                .categoryInCategory_Book(category1)
                .build();
        category_bookRepository.save(category_book2);
        Category_Book category_book3 = Category_Book.builder()
                .bookInCategory_Book(book2)
                .categoryInCategory_Book(category2)
                .build();
        category_bookRepository.save(category_book3);
        Category_Book category_book4 = Category_Book.builder()
                .bookInCategory_Book(book3)
                .categoryInCategory_Book(category1)
                .build();
        category_bookRepository.save(category_book4);
        Category_Book category_book5 = Category_Book.builder()
                .bookInCategory_Book(book4)
                .categoryInCategory_Book(category1)
                .build();
        category_bookRepository.save(category_book5);
        Category_Book category_book6 = Category_Book.builder()
                .bookInCategory_Book(book5)
                .categoryInCategory_Book(category1)
                .build();
        category_bookRepository.save(category_book6);

        //Author_Book
        Author_Book author_book1 = Author_Book.builder()
                .authorInAuthor_Book(author1)
                .bookInAuthor_Book(book)
                .build();
        author_bookRepository.save(author_book1);
        Author_Book author_book2 = Author_Book.builder()
                .authorInAuthor_Book(author1)
                .bookInAuthor_Book(book1)
                .build();
        author_bookRepository.save(author_book2);
        Author_Book author_book3 = Author_Book.builder()
                .authorInAuthor_Book(author2)
                .bookInAuthor_Book(book2)
                .build();
        author_bookRepository.save(author_book3);
        Author_Book author_book4 = Author_Book.builder()
                .authorInAuthor_Book(author3)
                .bookInAuthor_Book(book3)
                .build();
        author_bookRepository.save(author_book4);
        Author_Book author_book5 = Author_Book.builder()
                .authorInAuthor_Book(author4)
                .bookInAuthor_Book(book4)
                .build();
        author_bookRepository.save(author_book5);
        Author_Book author_book6 = Author_Book.builder()
                .authorInAuthor_Book(author1)
                .bookInAuthor_Book(book5)
                .build();
        author_bookRepository.save(author_book6);

        //Price
        Price price1 = Price.builder()
                .dateFrom(new Date(122,10,1))
                .dateTo(new Date(122,11,1))
                .value(40F)
                .atDiscount(false)
                .bookInPrice(book)
                .build();
        priceRepository.save(price1);
        Price price2 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(30F)
                .atDiscount(false)
                .bookInPrice(book)
                .build();
        priceRepository.save(price2);
        Price price3 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(45F)
                .atDiscount(false)
                .bookInPrice(book1)
                .build();
        priceRepository.save(price3);
        Price price4 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(50F)
                .atDiscount(false)
                .bookInPrice(book2)
                .build();
        priceRepository.save(price4);
        Price price5 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(48F)
                .atDiscount(false)
                .bookInPrice(book3)
                .build();
        priceRepository.save(price5);
        Price price6 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(46F)
                .atDiscount(false)
                .bookInPrice(book4)
                .build();
        priceRepository.save(price6);
        Price price7 = Price.builder()
                .dateFrom(new Date(122,11,1))
                .value(42F)
                .atDiscount(false)
                .bookInPrice(book5)
                .build();
        priceRepository.save(price7);

        //Client
        Client client1 = Client.builder()
                .name("Mateusz")
                .surname("Pietrych")
                .email("mateusz123@gmail.com")
                .telephoneNumber("123123123")
                .address(address1)
                .loyalPoints(13)
                .build();
        clientRepository.save(client1);
        Client client2 = Client.builder()
                .name("Maciek")
                .surname("Wajman")
                .email("maciekw@gmail.com")
                .telephoneNumber("111222333")
                .loyalPoints(11)
                .account(1)
                .build();
        clientRepository.save(client2);
        Client client3 = Client.builder()
                .name("Wiktor")
                .surname("Jeżowski")
                .email("wjezyk@gmail.com")
                .telephoneNumber("444222333")
                .loyalPoints(23)
                .account(3)
                .build();
        clientRepository.save(client3);

        //Complaint
        Complaint  complaint1 = Complaint.builder()
                .client(client2)
                .dateOfComplaintPlacement(new Date(122,11,18))
                .description("Paczka, która przyszła do mnie była przemoczona i wszystkie książki uległy zniszczeniu")
                .worker(1)
                .complaintState(complaintState1)
                .build();
        complaintRepository.save(complaint1);
        Complaint  complaint2 = Complaint.builder()
                .client(client1)
                .dateOfComplaintHandling(new Date(123,0,10))
                .dateOfComplaintPlacement(new Date(122,9,1))
                .description("Książka źle zszyta. Po otwarciu od razu część stron wypadła.")
                .worker(2)
                .complaintState(complaintState2)
                .build();
        complaintRepository.save(complaint2);
        Complaint  complaint3 = Complaint.builder()
                .client(client1)
                .dateOfComplaintPlacement(new Date(122,10,7))
                .description("Bla bla bla zepsute")
                .worker(4)
                .complaintState(complaintState1)
                .build();
        complaintRepository.save(complaint3);
        Complaint  complaint4 = Complaint.builder()
                .client(client3)
                .dateOfComplaintHandling(new Date(122,7,8))
                .dateOfComplaintPlacement(new Date(122,6,9))
                .description("Zakupione książki mnie nie zachwyciły, a według recenzji powinienem się zachwycić!")
                .worker(1)
                .complaintState(complaintState3)
                .build();
        complaintRepository.save(complaint4);

        //Order
        Order order2 = Order.builder()
                .dateOfOrderPlacement(new Date(122, Calendar.DECEMBER, 29))
                .deliveryType("DHL")
                .orderValue(23.0)
                .payment(payment2)
                .address(address2)
                .complaint(complaint2)
                .client(client1)
                .orderState(orderState1)
                .build();
        orderRepository.save(order2);
        Order order3 = Order.builder()
                .dateOfOrderPlacement(new Date(122, Calendar.DECEMBER, 28))
                .dateOfOrderSending(new Date(122, Calendar.DECEMBER, 29))
                .deliveryType("Poczta Polska")
                .orderValue(50.0)
                .payment(payment3)
                .address(address2)
                .complaint(complaint4)
                .client(client3)
                .orderState(orderState3)
                .build();
        orderRepository.save(order3);
        Order order1 = Order.builder()
                .dateOfOrderPlacement(new Date(122, Calendar.DECEMBER, 9))
                .dateOfOrderSending(new Date(122,Calendar.DECEMBER,9))
                .dateOfOrderDelivery(new Date(122, Calendar.DECEMBER, 10))
                .deliveryType("DHL")
                .orderValue(40.0)
                .invoice(invoice)
                .complaint(complaint1)
                .payment(payment1)
                .address(address1)
                .client(client2)
                .orderState(orderState5)
                .build();
        orderRepository.save(order1);
        Order order4 = Order.builder()
                .dateOfOrderPlacement(new Date(122, Calendar.DECEMBER, 4))
                .dateOfOrderSending(new Date(122,Calendar.DECEMBER,4))
                .dateOfOrderDelivery(new Date(122, Calendar.DECEMBER, 6))
                .deliveryType("DHL")
                .orderValue(60.0)
                .payment(payment4)
                .address(address1)
                .complaint(complaint3)
                .client(client1)
                .orderState(orderState5)
                .build();
        orderRepository.save(order4);


        //Postion
        Position position1 = Position.builder()
                .bookInPosition(book)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position1);
        Position position2 = Position.builder()
                .bookInPosition(book1)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position2);
        Position position3 = Position.builder()
                .bookInPosition(book2)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position3);
        Position position4 = Position.builder()
                .bookInPosition(book2)
                .orderInPosition(order2)
                .quantity(4)
                .build();
        positionRepository.save(position4);
        Position position5 = Position.builder()
                .bookInPosition(book3)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position5);
        Position position6 = Position.builder()
                .bookInPosition(book4)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position6);
        Position position7 = Position.builder()
                .bookInPosition(book5)
                .orderInPosition(order1)
                .quantity(1)
                .build();
        positionRepository.save(position7);
        Position position8 = Position.builder()
                .bookInPosition(book5)
                .orderInPosition(order3)
                .quantity(1)
                .build();
        positionRepository.save(position8);
        Position position9 = Position.builder()
                .bookInPosition(book5)
                .orderInPosition(order4)
                .quantity(1)
                .build();
        positionRepository.save(position9);
        Position position10 = Position.builder()
                .bookInPosition(book4)
                .orderInPosition(order4)
                .quantity(1)
                .build();
        positionRepository.save(position10);
    }
}
