package models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerCreatePojo {
    private List<PetsItem> pets;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private Integer id;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Type{
        private String name;
        private Integer id;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PetsItem{
        private List<VisitsItem> visits;
        private String name;
        private Integer id;
        private Type type;
        private Integer ownerId;
        private String birthDate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VisitsItem{
        private String date;
        private Integer petId;
        private String description;
        private Integer id;
    }

}