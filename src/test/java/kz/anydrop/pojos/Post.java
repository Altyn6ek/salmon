package kz.anydrop.pojos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Post {
    public int userId;
    public int id;
    public String title;
    public String body;
}
