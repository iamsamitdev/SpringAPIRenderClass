package com.itgenius.springboot_store_api.dto

import java.math.BigDecimal
import java.time.LocalDateTime

import java.time.format.DateTimeFormatter

data class ProductCategoryDTO(
    val id: Int,
    val productName: String?,
    val unitPrice: BigDecimal?,
    val unitInStock: Int?,
    val productPicture: String?,
    val categoryId: Int,
    val categoryName: String?,
    val createdDate: String,
    val modifiedDate: String?
) {
    companion object {
        private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        // ฟังก์ชันเพื่อสร้าง ProductCategoryDTO จาก Entity
        fun fromEntity(
            id: Int,
            productName: String?,
            unitPrice: BigDecimal?,
            unitInStock: Int?,
            productPicture: String?,
            categoryId: Int,
            categoryName: String?,
            createdDate: LocalDateTime,
            modifiedDate: LocalDateTime?
        ): ProductCategoryDTO {
            return ProductCategoryDTO(
                id = id,
                productName = productName,
                unitPrice = unitPrice,
                unitInStock = unitInStock,
                productPicture = productPicture,
                categoryId = categoryId,
                categoryName = categoryName,
                createdDate = createdDate.format(formatter),
                modifiedDate = modifiedDate?.format(formatter)
            )
        }
    }

    // เพิ่ม constructor เดิมที่ใช้โดย JPQL
    constructor(
        id: Int,
        productName: String?,
        unitPrice: BigDecimal?,
        unitInStock: Int?,
        productPicture: String?,
        categoryId: Int,
        categoryName: String?,
        createdDate: LocalDateTime,
        modifiedDate: LocalDateTime?
    ) : this(
        id,
        productName,
        unitPrice,
        unitInStock,
        productPicture,
        categoryId,
        categoryName,
        createdDate.format(formatter),
        modifiedDate?.format(formatter)
    )
}
