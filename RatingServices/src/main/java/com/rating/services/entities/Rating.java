package com.rating.services.entities;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("user_ratings")
public class Rating {
    @Id
    private String id;            //ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}

