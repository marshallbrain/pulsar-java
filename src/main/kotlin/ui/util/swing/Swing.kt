package ui.util.swing

import java.awt.GridBagConstraints
import java.awt.Insets

fun initGridBagConstraints(c: GridBagConstraints) {
	c.gridx = 0
	c.gridy = 0
	c.weightx = 0.0
	c.weighty = 0.0
	c.fill = GridBagConstraints.BOTH
	c.insets = Insets(4, 4, 2, 4)
}