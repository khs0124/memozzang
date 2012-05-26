package memo.com.pack;

import android.content.res.Resources;


public class WidgetItem1
  implements WidgetItemInterface
{
  public WidgetViewInterface createWidgetView()
  {
    return new WidgetView1();
  }

  public WidgetItemProperties getExtraProperties()
  {
    return new NewWidgetProperties();
  }

  public int getIconResource()
  {
    return 2130837535;
  }

  public String getName()
  {
    return "rosiewidgets.note";
  }

  public int getTextResource()
  {
    return 2131099648;
  }

  public class NewWidgetProperties extends WidgetItemProperties
  {
    public NewWidgetProperties()
    {
    }

    public String getDescription(int paramInt, Resources paramResources)
    {
      return paramResources.getString(2131099658);
    }
  }
}