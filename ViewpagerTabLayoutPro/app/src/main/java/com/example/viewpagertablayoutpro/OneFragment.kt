package com.example.viewpagertablayoutpro

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagertablayoutpro.databinding.FragmentOneBinding
import com.example.viewpagertablayoutpro.databinding.FragmentTwoBinding

class OneFragment : Fragment() {
    lateinit var binding: FragmentOneBinding
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList>
    lateinit var toggle: ActionBarDrawerToggle

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        dataList = mutableListOf()
        for(i in 1..30){
            if(i % 2 == 0){
                dataList.add(DataList("홍길동${i}", "${20+i}세", "aaa${i}@naver.com", R.drawable.ironman))
            }else{
                dataList.add(DataList("홍길동${i}", "${20+i}세", "aaa${i}@naver.com", R.drawable.wonderwoman))
            }
        }

        val customRecycleAdapter = CustomRecycleAdapter(dataList)
        binding.recyclerview.adapter = customRecycleAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(mainActivity)
        binding.recyclerview.addItemDecoration(MyDecoration(activity as Context))
        return binding.root
    }
}