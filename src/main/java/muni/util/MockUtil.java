package muni.util;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import muni.model.Model;

import java.time.Instant;

public class MockUtil {
    public static Model.Organization buildOrganization() {
        return Model.Organization.newBuilder()
                .setName("Costco Enterprise")
                .setContactChannels(buildContactChannels())
                .build();
    }

    public static Model.Person buildPerson(){
        return  buildPerson("99","Jane", "Doe");
    }
    public static Model.Person buildPerson(String id, String firstName, String lastname ) {

        Timestamp ts = Timestamps.fromMillis(System.currentTimeMillis());

        return Model.Person.newBuilder().setId(id)
                .setFirstName(firstName)
                .setLastName(lastname)
                .setContactChannels(buildContactChannels())
                .setCreateTime(ts)
                .setUpdateTime(ts)
                .build();
    }


    public static Model.ContactChannels buildContactChannels(){
        return Model.ContactChannels.newBuilder()
                .setEmail(Model.Email.newBuilder().setValue("me@gmail.com").build())
                .setPhone1(Model.Phone.newBuilder().setCountryCode(1).setNumber(123445678).setExt("xs234").build())
                .setPhone2(Model.Phone.newBuilder().setCountryCode(1).setNumber(123445678).setExt("xs234").build())
                .setPostalAddress(buildAddress())
                .build();
    }

    public static Model.PostalAddress buildAddress(){
        Instant now = Instant.now();
        return Model.PostalAddress.newBuilder()
                .setStreetNum("111")
                .setStreetName("New Street")
                .setCity("Toronto")
                .setProvince("Ontario")
                .setCountry("Canada")
                .setPostalCode("L1L2M2")
                .setId("3")
//                .setCreateTime(Timestamp.newBuilder().setSeconds(now.getEpochSecond()).build())
//                .setUpdateTime(Timestamp.newBuilder().setSeconds(now.getEpochSecond()).build())
                .build();
    }
}
