package models;

import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private List<PetsItem> pets;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerDto)) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return Objects.equals(firstName, ownerDto.firstName) && Objects.equals(lastName, ownerDto.lastName) && Objects.equals(address, ownerDto.address) && Objects.equals(city, ownerDto.city) && Objects.equals(telephone, ownerDto.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, city, telephone);
    }

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