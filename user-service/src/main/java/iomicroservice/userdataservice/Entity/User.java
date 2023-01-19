package iomicroservice.userdataservice.Entity;



import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min=2, max=10)
    private String nom;

    @NotNull
    @Size(min=2, max=10)
    private String prenom;

    @NotNull
    private Integer telephone;
    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Positive
    private Integer tarifHoraire;
    private Role role;


    @Transient
    private List<Formation> formations = new ArrayList<>();







}
