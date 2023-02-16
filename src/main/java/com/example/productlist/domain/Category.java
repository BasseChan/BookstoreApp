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
@Table(name = "categories")

public class Category extends BaseEntity   {

    @Builder
    public Category(Long id, String categoryName) {
        super(id);
        this.categoryName = categoryName;
    }

    @Column(name = "categoryName", nullable = false,  length = 30)
    private String categoryName;

    @OneToMany(
            mappedBy = "categoryInCategory_Book"
    )
    private List<Category_Book> category_bookList;
}
