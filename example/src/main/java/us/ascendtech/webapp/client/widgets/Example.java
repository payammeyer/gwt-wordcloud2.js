package us.ascendtech.webapp.client.widgets;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import us.ascendtech.webapp.client.services.ExampleServiceProvider;
import us.ascendtech.wordcloud2.client.WordCloud2ChartOptions;
import us.ascendtech.wordcloud2.client.WordCloudChart;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;

import java.util.List;

/**
 * Created by pmeyer on 12/30/15.
 */
public class Example implements EntryPoint {

	@Override
	public void onModuleLoad() {

		final VerticalPanel main = new VerticalPanel();
		main.setSpacing(15);

		final WordCloudChart wordCloudChart = new WordCloudChart() {
			@Override
			public void clickedWord(String tag, int frequency) {
				// TODO: Implement clicking on words
				Window.alert("Clicked '" + tag + "'");
			}
		};

		main.add(wordCloudChart);

		ExampleServiceProvider.get().getExampleService().getWordCloudData(new AsyncCallback<List<WordCloudChartData>>() {
			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(List<WordCloudChartData> result) {

				WordCloud2ChartOptions options = WordCloud2ChartOptions.create();
				options.setWeightFactor((Math.pow(2.3, 2.3) * (Window.getClientWidth() - 200) / 1024));
				options.setGridSize(Math.round(16 * (Window.getClientWidth() - 200) / 1024));
				options.setRotateRatio(0.5);
				options.setBackgroundColor("#ffe0e0");
				options.setFontFamily("Times, serif");
				options.setColorFunction(createColorFunction());

				wordCloudChart.setChartDataAndOptions(result, options);

				RootPanel.get().add(main);

				wordCloudChart.draw();
			}
		});

	}

	public final native JavaScriptObject createColorFunction() /*-{
        return function (word, weight) {
            return (weight === 40) ? '#f02222' : '#c09292';
        }
    }-*/;

}
