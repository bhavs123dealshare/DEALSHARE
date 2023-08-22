package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.product_list)



//        val productRecyclerView: RecyclerView = findViewById(R.id.productRecyclerView)
//
//        // Create a list of products (you would retrieve this from API)
//        val products: List<Product> =  // Retrieve products from API or local storage
//
//        // Create and set up the ProductAdapter
//        val productAdapter = ProductAdapter(products)
//        productRecyclerView.adapter = productAdapter
//        productRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    // Initialize views and set up UI interactions
    // Fetch and display list of products based on API calls
    // Implement category filters and click listeners
}



