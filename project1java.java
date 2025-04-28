function goToResultPage() {
  const stockName = document.getElementById('stockName').value.trim();
  const buyPrice = parseFloat(document.getElementById('buyPrice').value);
  const sellPrice = parseFloat(document.getElementById('sellPrice').value);
  const stock = stocks[stockName];
  const resultDiv = document.getElementById('result');
  const profitAmount = document.getElementById('profitAmount');
  const profitPercentage = document.getElementById('profitPercentage');
  const purificationAmount = document.getElementById('purificationAmount');

  if (stock && buyPrice > 0 && sellPrice > 0) {
    const purification = stock.purification;
    const profit = (sellPrice - buyPrice) * (1 - purification);
    const profitPercent = ((profit / buyPrice) * 100).toFixed(2);
    const purificationValue = (sellPrice - buyPrice) * purification;

    // إخفاء المحتوى المؤقت
    resultDiv.textContent = '';
    profitAmount.textContent = profit.toFixed(2);
    profitPercentage.textContent = profitPercent;
    purificationAmount.textContent = purificationValue.toFixed(2);

    // إضافة تأثير الأنيميشن لظهور النتيجة
    resultDiv.classList.add('fadeInResult');
    profitAmount.classList.add('fadeInResult');
    profitPercentage.classList.add('fadeInResult');
    purificationAmount.classList.add('fadeInResult');

    // إظهار الصفحة
    document.getElementById('resultPage').classList.remove('hidden');
    document.getElementById('calculatorPage').classList.add('hidden');
  } else {
    alert('الرجاء التأكد من جميع المدخلات.');
  }
}

function goBack() {
  if (window.history.length > 1) {
    window.history.back(); // الرجوع إلى الصفحة السابقة في سجل المتصفح
  } else {
    window.location.href = '/'; // إذا لم يكن هناك سجل، إعادة التوجيه إلى الصفحة الرئيسية
  }
}

