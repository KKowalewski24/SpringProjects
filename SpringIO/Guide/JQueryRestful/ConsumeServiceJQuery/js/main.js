"use strict";

const documentRef = $(document);
const greetingId = $("#greeting-id");
const greetingContent = $("#greeting-content");

documentRef.ready(() => {
  axios.get("http://localhost:8080/greeting")
    .then((res) => {
      console.log(res);
      greetingId.append(res.data.id);
      greetingContent.append(res.data.content);
    })
    .catch((err) => {
      console.log(err);
    })
});
