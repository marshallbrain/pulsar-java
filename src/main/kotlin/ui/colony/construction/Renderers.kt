package ui.colony.construction

import com.marshalldbrain.pulsar.colony.districts.District
import com.marshalldbrain.pulsar.colony.districts.DistrictType
import java.awt.Color
import java.awt.Component
import javax.swing.DefaultListCellRenderer
import javax.swing.JList
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer

object OptionsCellRenderer : DefaultTableCellRenderer() {
	
	override fun getTableCellRendererComponent(
		table: JTable?,
		value: Any?,
		isSelected: Boolean,
		hasFocus: Boolean,
		row: Int,
		column: Int
	): Component {
		
		if (value is DistrictType) {
			
			val v: Any = when(column) {
				0 -> value.id
				1 -> value.time
				else -> "error"
			}
			
			return super.getTableCellRendererComponent(table, v, isSelected, hasFocus, row, column)

		}

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)
		
	}
	
}

object SlotCellRenderer: DefaultListCellRenderer() {
	
	override fun getListCellRendererComponent(
		list: JList<out Any>?,
		value: Any?,
		index: Int,
		isSelected: Boolean,
		cellHasFocus: Boolean
	): Component {
		
		return when(value) {
			
			is District -> {
				val v = "${value.type.id} (${value.amount})"
				super.getListCellRendererComponent(list, v, index, isSelected, cellHasFocus)
			}

			is List<*> -> {
				val v = "Untooled District (${value.size} remaining)"
				super.getListCellRendererComponent(list, v, index, isSelected, cellHasFocus)
			}
			
			else -> super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
			
		}
		
	}
	
}

object ResourcesCellRenderer: DefaultTableCellRenderer() {

	override fun getTableCellRendererComponent(
		table: JTable?,
		value: Any?,
		isSelected: Boolean,
		hasFocus: Boolean,
		row: Int,
		column: Int
	): Component {

		if (value is String) {
			if (value.contains("\$")) {
				val cell = super.getTableCellRendererComponent(table, value.replace("\$", ""), isSelected, hasFocus, row, column)
				cell.background = Color.LIGHT_GRAY
				return cell
			}
		}

		val cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)
		cell.background = Color.WHITE
		return cell

	}

}