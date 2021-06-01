package kpfu.itis.petproject.activity

import androidx.appcompat.app.AppCompatActivity
import kpfu.itis.petproject.R
import kpfu.itis.petproject.di.diKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.kodein

class MainActivity : AppCompatActivity(R.layout.activity_main), KodeinAware {

    override val kodein by closestKodein()
}
