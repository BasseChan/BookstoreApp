package com.example.productlist.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "authors")

public class Author extends BaseEntity  {

    @Builder
    public Author(Long id, String name, String surname) {
        super(id);
        this.name = name;
        this.surname = surname;
    }

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @OneToMany(
            mappedBy = "authorInAuthor_Book"
    )
    private List<Author_Book> author_books;

    public String getFullName() {
        if(name == null) return surname;
        return name + " " + surname;
    }

    public void setFullName(String fullName) {
        String[] list = fullName.split(" ");
        surname = list[list.length-1];
        if(list.length > 1) {
            String newName = "";
            for(int i=0; i<list.length - 1; i++) {
                newName += list[i];
            }
            name = newName;
        }
    }
}
