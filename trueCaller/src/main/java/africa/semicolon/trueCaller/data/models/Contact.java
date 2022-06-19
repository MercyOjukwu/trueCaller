package africa.semicolon.trueCaller.data.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    @NonNull
    private String lastName;
    private String phoneNumber;



}
