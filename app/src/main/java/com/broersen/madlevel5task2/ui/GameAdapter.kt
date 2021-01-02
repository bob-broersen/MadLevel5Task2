package com.broersen.madlevel5task2.ui


import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.broersen.madlevel5task2.model.Game
import com.broersen.madlevel5task2.R
import com.broersen.madlevel5task2.databinding.ItemGameBinding
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class GameAdapter(private val games: List<Game>):
        RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemGameBinding.bind(itemView)

        @RequiresApi(Build.VERSION_CODES.O)
        fun dataBind(game: Game){
            binding.tvDate.text = game.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
            binding.tvTitle.text = game.title
            binding.tvPlatform.text = game.platform
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(games[position])
    }
}