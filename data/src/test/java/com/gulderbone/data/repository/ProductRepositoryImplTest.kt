package com.gulderbone.data.repository

import com.gulderbone.domain.feature.model.Product
import com.gulderbone.data.model.product.ProductResponse
import com.gulderbone.data.model.product.ProductStateResponse
import com.gulderbone.data.repository.mapper.ProductStateMapper
import com.gulderbone.data.service.ProductService
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ProductRepositoryImplTest {

    private val fakeProductStateResponse = ProductStateResponse(
        code = "12345678",
        product = ProductResponse(
            productName = "product",
            categoriesTags = listOf("category 1, category 2"),
        )
    )

    private val fakeProduct = Product(
        name = "product",
        tags = listOf("category 1, category 2"),
    )

    private val mockProductService = mock<ProductService> {
        onBlocking { getProductByBarcode(any()) } doReturn fakeProductStateResponse
    }
    private val mockProductStateMapper = mock<ProductStateMapper> {
        on { from(any()) } doReturn fakeProduct
    }

    private val tested = ProductRepositoryImpl(mockProductService, mockProductStateMapper)

    @Test
    fun `when getProductByBarcode, then gets product by barcode and maps it`() = runTest {
        val barcode = "12345678"

        val expected = fakeProduct

        val result = tested.getProductByBarcode(barcode)

        assertEquals(
            expected,
            result,
        )

        verify(mockProductService).getProductByBarcode(barcode)
        verify(mockProductStateMapper).from(any())
    }
}
