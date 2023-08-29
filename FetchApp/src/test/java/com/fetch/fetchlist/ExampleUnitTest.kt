package com.fetch.fetchlist

import com.fetch.fetchlist.dto.Item
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun isList_SortedAndFiltered(){
        var itemList = listOf(Item(1, 200, "Romit",), Item(1, 200, ""), Item(1, 201, "Romit"))
        itemList = itemList.filter { v -> !v.name.isNullOrBlank() }.sortedWith((Comparator.comparing(Item::listId).thenComparing(Item::name)))

        var expectedList = listOf(Item(1, 200, "Romit",), Item(1, 201, "Romit"))
        assertEquals(itemList, expectedList)
    }
}