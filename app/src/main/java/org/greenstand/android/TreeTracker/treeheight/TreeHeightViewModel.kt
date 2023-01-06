package org.greenstand.android.TreeTracker.treeheight

import androidx.compose.material.ButtonColors
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.greenstand.android.TreeTracker.models.Tree
import org.greenstand.android.TreeTracker.models.TreeCapturer
import org.greenstand.android.TreeTracker.view.AppButtonColors


data class TreeHeightSelectionState(
    val colours: List<ButtonColors> = listOf(AppButtonColors.ProgressGreen,AppButtonColors.MessagePurple,AppButtonColors.Yellow,AppButtonColors.SkyBlue,AppButtonColors.UploadOrange),
    val selectedColour: ButtonColors? = null,
)

class TreeHeightSelectionViewModel(
    private val treeCapturer: TreeCapturer,
) : ViewModel() {
    private val _state = MutableLiveData<TreeHeightSelectionState>()
    val state: LiveData<TreeHeightSelectionState> = _state

    fun selectColor(colors: ButtonColors) {
        // TODO add proper color values
        treeCapturer.addAttribute(Tree.TREE_COLOR_ATTR_KEY, colors.toString())
        _state.value = TreeHeightSelectionState(selectedColour = colors)
    }
}