package com.srmstudios.stopwatchtimer.ui.stopwatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.srmstudios.stopwatchtimer.R
import com.srmstudios.stopwatchtimer.databinding.FragmentStopwatchBinding
import com.srmstudios.stopwatchtimer.service.StopwatchService
import com.srmstudios.stopwatchtimer.util.BaseFragment
import com.srmstudios.stopwatchtimer.util.formatMillisToTimer

class StopwatchFragment : BaseFragment<FragmentStopwatchBinding>(R.layout.fragment_stopwatch) {

    override val bindingInflater: (View) -> FragmentStopwatchBinding
        get() = FragmentStopwatchBinding::bind

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        binding.btnReset.isEnabled = !StopwatchService.isTracking.value!! && StopwatchService.elapsedMilliSeconds.value!! != 0L
    }

    private fun setupViews(){
        StopwatchService.isTracking.observe(viewLifecycleOwner){ isTracking ->
            binding.btnStart.isEnabled = !isTracking
            binding.btnPause.isEnabled = isTracking
            binding.btnReset.isEnabled = !isTracking && StopwatchService.elapsedMilliSeconds.value!! != 0L
        }
        StopwatchService.elapsedMilliSeconds.observe(viewLifecycleOwner){ elapsedMillis ->
            binding.txtStopwatchTime.text = formatMillisToTimer(elapsedMillis,true)
            binding.btnReset.isEnabled = !StopwatchService.isTracking.value!! && elapsedMillis != 0L
        }
    }

    private fun setupListeners(){
        binding.btnStart.setOnClickListener {
            commandService(StopwatchService.SERVICESTATE.START_OR_RESUME)
        }
        binding.btnPause.setOnClickListener {
            commandService(StopwatchService.SERVICESTATE.PAUSE)
        }
        binding.btnReset.setOnClickListener {
            commandService(StopwatchService.SERVICESTATE.RESET)
        }
    }

    private fun commandService(servicestate: StopwatchService.SERVICESTATE){
        context?.let { context ->
            val intent = Intent(context,StopwatchService::class.java)
            intent.action = servicestate.name
            context.startService(intent)
        }
    }
}





