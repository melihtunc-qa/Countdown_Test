import React from 'react';
import { shallow } from 'enzyme';
import App from '../components/App/App';
import Timer from '../components/Timer/Timer';
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

describe('App Component', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<App />);
    expect(wrapper).toMatchSnapshot();
  });

  it('renders Timer component', () => {
    const wrapper = shallow(<App />);
    expect(wrapper.find(Timer)).toHaveLength(1);
  });
});
