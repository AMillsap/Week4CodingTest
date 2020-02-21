package com.example.week4codingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    /*1. Create a program which checks if the string has the correct order of parenthesis/brackets.
    ({})[] = true, []{]}[ = false
    2. Given a string and a non-empty substring sub, compute recursively
    if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.

    strCopies("catcowcat", "cat", 2) → true
    strCopies("catcowcat", "cow", 2) → false
    strCopies("catcowcat", "cow", 1) → true

    3. Given a sorted array of int (both negative and positive values possible),
    write an equation that will square each value in the array and return a sorted array as well.
    This must have a O(n) time complexity (so no resort)*/



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val string = "He(llo{Today is}Friday)I am [excited] for the weekend"
        val string2 = "My name { is bob ( I ) like [ to ] sleep }"
        Log.d("TAG", checkBrackets(string).toString())

        val array = intArrayOf(-6, 3, 5, 7)
        val newArray = squareAndSortArray(array)
        Log.d("TAG", Arrays.toString(newArray))

        Log.d("TAG", stringCopies("catcowcat", "cat", 2).toString())
    }

    fun checkBrackets(string : String) : Boolean
    {
        val properBrackets = charArrayOf('(','{', '}', ')', '[', ']')
        var count = 0
        var charArray = string.toCharArray()
        for(i in 0 until charArray.size)
        {
            when(charArray[i])
            {
                '(' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
                '{' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
                '}' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
                ')' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
                '[' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
                ']' ->
                {
                    if(properBrackets[count] != charArray[i])
                    {
                        return false
                    }
                    else
                    {
                        count++
                    }
                }
            }
        }
        return true
    }

    fun stringCopies(searchedString: String, wordSearch : String, amountRepeated : Int) : Boolean
    {
        return findNumberOfWords(searchedString, wordSearch) == amountRepeated
    }

    fun findNumberOfWords(searchedString : String, wordSearch : String) : Int
    {
        var searchedLength = searchedString.length
        var wordLength = wordSearch.length
        if (searchedLength < wordLength)
        {
            return 0
        }
        if (searchedString.substring(0, wordLength) == wordSearch)
        {
            return 1 + findNumberOfWords(searchedString.substring(1), wordSearch)
        }
        else
        {
            return findNumberOfWords(searchedString.substring(1), wordSearch)
        }
    }

    fun squareAndSortArray(array: IntArray) : IntArray
    {
        var newArray : IntArray = IntArray(array.size)

        for (i in 0 until array.size)
        {
            if(i < (array.size - 1))
            {
                if (Math.abs(array[i]) > Math.abs(array[i + 1]))
                {
                    var tempNum = array[i]
                    array[i] = array[i + 1]
                    array[i + 1] = tempNum
                }
            }
            newArray[i] = Math.pow(array[i].toDouble(), 2.0).toInt()
        }

        return newArray
    }
}
