package ru.netology.nmedia.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.ui.filesList.PostsAdapter
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel : PostViewModel by viewModels()
        val adapter = PostsAdapter{
            viewModel.onLikeClicked(it.id)
        }
        binding.list.adapter = adapter
        viewModel.data.observe(this){posts->
            adapter.submitList(posts)
        }
    }
}