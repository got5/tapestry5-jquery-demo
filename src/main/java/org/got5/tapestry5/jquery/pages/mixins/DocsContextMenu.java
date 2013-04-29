package org.got5.tapestry5.jquery.pages.mixins;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.got5.tapestry5.jquery.data.ContextMenuItem;

@Import(stylesheet = "context:css/contextMenu/contextMenu.css")
public class DocsContextMenu {

	@Inject
	private Messages messages;

	public List<ContextMenuItem> getContextMenuItems() {
		List<ContextMenuItem> items = new ArrayList<ContextMenuItem>();

		items.add(new ContextMenuItem("Edit item label", "editEvent", "edit"));

		// Separator
		items.add(ContextMenuItem.getSeparator());

		// No icon for this item.
		items.add(new ContextMenuItem(messages.get("copy-item-label"),
				"copyEvent"));

		// Zoom icon is defined in contextMenu.css.
		items.add(new ContextMenuItem("Paste", "zoomEvent", "zoom"));
		return items;
	}

	@OnEvent(value = "editEvent")
	public void onEditEvent() {
		// Handler on Edit item click.
	}

	@OnEvent(value = "copyEvent")
	public void onCopyEvent() {
		// Handler on Copy item click.
	}

	@OnEvent(value = "zoomEvent")
	public void onZoomEvent() {
		// Handler on Zoom item click.
	}
}
