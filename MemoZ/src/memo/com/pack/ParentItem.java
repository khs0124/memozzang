package memo.com.pack;

import android.app.Activity;

public class ParentItem implements WidgetGroupItemInterface
{
public WidgetViewInterface createWidgetView()
{
  return null;
}

public WidgetItemProperties getExtraProperties()
{
  return new WidgetItemProperties();
}

public int getIconResource()
{
  return 2130837509;
}

public String getName()
{
  return "rosiewidgets.note.ParentItem";
}

public int getTextResource()
{
  return 2131099648;
}

public WidgetItemInterface[] listSubItems()
{
  WidgetItemInterface[] arrayOfWidgetItemInterface = new WidgetItemInterface[1];
  arrayOfWidgetItemInterface[0] = new WidgetItem1();
  return arrayOfWidgetItemInterface;
}

public boolean onSelectedAt(int paramInt, Activity paramActivity)
{
  return false;
}
}