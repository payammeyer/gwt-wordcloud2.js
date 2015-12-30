package us.ascendtech.wordcloud2.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

public class WordCloud2ChartOptions extends JavaScriptObject {

	public static WordCloud2ChartOptions create() {
		return createObject().cast();
	}

	protected WordCloud2ChartOptions() {
	}

	public final native WordCloud2ChartOptions setList(JsArray<JavaScriptObject> list) /*-{
        this.list = list;
        return this;
    }-*/;

	public final native WordCloud2ChartOptions setGridSize(int gridSize) /*-{
        this.gridSize = gridSize;
        return this;
    }-*/;

	public final native WordCloud2ChartOptions setOrigin(JsArrayInteger origin) /*-{
        this.origin = origin;
        return this;
    }-*/;

	public final native WordCloud2ChartOptions setWeightFactor(double weightFactor) /*-{
        this.weightFactor = weightFactor;
        return this;
    }-*/;

	public final native WordCloud2ChartOptions setInstanceId(String instanceId) /*-{
        this.instanceId = instanceId;
        return this;
    }-*/;

	public final native WordCloud2ChartOptions setMinSize(int minSize) /*-{
        this.minSize = minSize;
        return this;
    }-*/;

}
